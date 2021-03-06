/*global WM, Application */

Application.$controller("GooglemapsController", ["$scope", "Utils", "$element", "$timeout",
    function ($scope, Utils, $element, $timeout) {
        "use strict";

        var _locations = [],
            _icon = "",
            _location = "",
            _info = "",
            _center,
            defaultMarkers = [
                {
                    "latlng": {
                        "latitude": undefined,
                        "longitude": undefined
                    }
                }
            ],
            mapCtrl = {},
            mapContainer,
            gMap,
            firstTime = true,
            defaultCenter = {
                "latitude": 0,
                "longitude": 0
            };

        $scope.map = {
            "center": defaultCenter,
            "zoom": 5,
            "markers": defaultMarkers,
            "control": mapCtrl
        };

        function constructMarkersModel() {
            $scope.map.markers = defaultMarkers;
            var latSum = 0, lngSum = 0, len;
            if (_locations) {
                $scope.map.markers = _locations.map(function (marker, index) {
                    var latlng = marker, lat, lng;
                    if (_location && _location !== "Root") {
                        latlng = Utils.findValueOf(marker, _location) || {};
                    }

                    lat = +(latlng.lat);
                    lng = +(latlng.lng);

                    latSum += isNaN(lat) ? 0 : lat;
                    lngSum += isNaN(lng) ? 0 : lng;

                    return {
                        "latlng": {
                            "latitude": lat,
                            "longitude": lng
                        },
                        "icon": _icon ? Utils.findValueOf(marker, _icon) : "",
                        "info": _info ? Utils.findValueOf(marker, _info) : "",
                        "id": $scope.$id + '_' + index
                    };
                });
                if (!_center) {
                    len = $scope.map.markers.length;
                    if (len > 0 && mapCtrl.refresh) {
                        mapCtrl.refresh({"latitude": (latSum / len), "longitude": (lngSum / len)});
                    }
                }
            }
        }

        function onLocationsChange(newVal) {

            var markerObj,
                widgetProps = $scope.$parent.widgetProps,
                options = [];
            widgetProps.location.options = options;
            widgetProps.icon.options = options;
            widgetProps.info.options = options;

            _locations = [];

            if (WM.isArray(newVal)) {
                _locations = newVal;
            } else {
                if (WM.isObject(newVal)) {
                    if (WM.isArray(newVal.data)) {
                        _locations = newVal.data;
                    } else {
                        _locations = [newVal];
                    }
                }
            }

            if (_locations.length > 0) {
                markerObj = _locations[0];

                Utils.getAllKeysOf(markerObj).forEach(function (key) {
                    options.push(key);
                });
                options.unshift("Root");
            }
            constructMarkersModel();
        }

        /* Define the property change handler. This function will be triggered when there is a change in the prefab property */
        function propertyChangeHandler(key, newVal) {
            switch (key) {
            case "locations":
                onLocationsChange(newVal);
                break;
            case "location":
                _location = newVal;
                constructMarkersModel();
                break;
            case "icon":
                _icon = newVal;
                constructMarkersModel();
                break;
            case "info":
                _info = newVal;
                constructMarkersModel();
                break;
            case "height":
                if (newVal) {
                    newVal = parseInt(newVal, 10);
                    if (isNaN(newVal)) {
                        return;
                    }

                    if (!mapContainer && newVal) {
                        mapContainer = $element.find(".angular-google-map-container");
                    }
                    mapContainer.css("height", newVal - 10);
                }
                break;
            case "center":
                _center = null;
                newVal = newVal || {};
                if (newVal.lat && newVal.lng) {
                    newVal.lat = +newVal.lat;
                    newVal.lat = isNaN(newVal.lat) ? 0 : newVal.lat;
                    newVal.lng = +newVal.lng;
                    newVal.lng = isNaN(newVal.lng) ? 0 : newVal.lng;
                    _center = newVal;
                    if (mapCtrl.refresh) {
                        mapCtrl.refresh({"latitude": newVal.lat, "longitude": newVal.lng});
                    }
                }
                break;
            case "zoom":
                newVal = +newVal;
                if (!isNaN(newVal)) {
                    $scope.map.zoom = newVal;
                }

                if (firstTime) {
                    firstTime = false;
                    if (!gMap) {
                        gMap = mapCtrl.getGMap();
                    }
                    gMap.zoom = newVal;
                }
                break;
            }
        }

        /* register the property change handler */
        $scope.propertyManager.add($scope.propertyManager.ACTIONS.CHANGE, propertyChangeHandler);

        $element.closest('.app-prefab').isolateScope().redraw = function () {
            $timeout(function () {
                if (!mapCtrl.refresh) {
                    return;
                }
                if (_center) {
                    mapCtrl.refresh({"latitude": _center.lat, "longitude": _center.lng});
                } else {
                    mapCtrl.refresh();
                }
            }, 10, false);
        };
    }]);
$(function () {
    var springfox = {
        "baseUrl": function () {
            var urlMatches = /(.*)\/index.html.*/.exec(window.location.href);
            return urlMatches[1].replace('api', '');
        },
        "securityConfig": function (cb) {
            $.getJSON(this.baseUrl() + "/swagger-resources/configuration/security", function (data) {
                cb(data);
            });
        },
        "uiConfig": function (cb) {
            $.getJSON(this.baseUrl() + "/swagger-resources/configuration/ui", function (data) {
                cb(data);
            });
        }
    };
    window.springfox = springfox;

    function log() {
        if ('console' in window) {
            console.log.apply(console, arguments);
        }
    }

    window.springfox.uiConfig(function (data) {
        window.swaggerUi = new SwaggerUi({
            dom_id: "swagger-ui-container",
            validatorUrl: data.validatorUrl,
            supportedSubmitMethods: ['get', 'post', 'put', 'delete', 'patch'],
            onComplete: function () {

                if (window.SwaggerTranslator) {
                    window.SwaggerTranslator.translate();
                }

                $('pre code').each(function (i, e) {
                    hljs.highlightBlock(e)
                });

            },
            onFailure: function () {
                log("Unable to Load SwaggerUI");
            },
            docExpansion: "none",
            apisSorter: "alpha",
            showRequestHeaders: false
        });

    });

    $(document).ready(function () {
        var relativeLocation = springfox.baseUrl();

        $.getJSON(relativeLocation + "/swagger-resources", function (data) {
            if (window.swaggerUi === undefined) {
                log("An error occurred during the execution. Reload the page.")
                window.location.reload(true);
            }

            window.swaggerUi.headerView.trigger('update-swagger-ui', {
                url: data[0].location
            });
        });
    });

});



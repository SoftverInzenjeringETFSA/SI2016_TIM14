/* eslint-env node */
const EmberApp = require('ember-cli/lib/broccoli/ember-app');
var mergeTrees = require('broccoli-merge-trees');

module.exports = function(defaults) {
  var app = new EmberApp(defaults, {
    'ember-bootstrap': {
      'bootstrapVersion': 3,
      'importBootstrapFont': true,
      'importBootstrapCSS': true
    }
  });

  // Use `app.import` to add additional libraries to the generated
  // output files.
  //
  // If you need to use different assets in different
  // environments, specify an object as the first parameter. That
  // object's keys should be the environment name and the values
  // should be the asset to use in that environment.
  //
  // If the library that you are including contains AMD or ES6
  // modules that you would like to import into your application
  // please specify an object with the list of modules as keys
  // along with the exports of each module as its value.

  // SHARED STYLESHEETS
  app.import('app/styles/shared/shared-header.css', { destDir: 'assets' });

  // ROUTE STYLESHEETS
  app.import('app/styles/routes/login.css', { destDir: 'assets' });

  // COMPONENT STYLESHEETS
  
  // THIRD-PARTY LIBRARIES STYLESHEETS
  app.import('bower_components/bootstrap/dist/css/bootstrap.min.css')

  return app.toTree();
};

import DS from 'ember-data';

var _modelProperties = ['id','name','description'];

export default DS.Model.extend({
     modelProperties: _modelProperties,

});

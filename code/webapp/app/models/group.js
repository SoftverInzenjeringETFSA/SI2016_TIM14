import DS from 'ember-data';
import BaseModel from './base-model';

var _modelProperties = ['id','name','description'];

export default DS.Model.extend({
     modelProperties: _modelProperties,

});

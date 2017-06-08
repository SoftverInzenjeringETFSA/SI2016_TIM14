import DS from 'ember-data';
import BaseModel from './base-model';

var _modelProperties = ['sourceUsername', 'targetUsername'];

export default BaseModel.extend({
     modelProperties: _modelProperties,
});

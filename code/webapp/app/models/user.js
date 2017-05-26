import DS from 'ember-data';
import BaseModel from './base-model';

var _modelProperties = ['email','firstName','gender','id','isAdmin','lastName','password', 'username', 'omeni', 'interesovanja', 'zanimanje', 'location'];

export default BaseModel.extend({
     modelProperties: _modelProperties,
     /*id: DS.attr(),
     firstName: DS.attr(),
     lastName: DS.attr(),
     username: DS.attr(),
     email: DS.attr(),
     gender: DS.attr(),
     dateOfBirth: DS.attr(),
     location: DS.attr(),
     about: DS.attr(),
     isAdmin: DS.attr()*/
});

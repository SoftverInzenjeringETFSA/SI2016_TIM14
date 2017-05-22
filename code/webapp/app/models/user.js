import DS from 'ember-data';

var _modelProperties = ['about','email','firstName','gender','id','isAdmin','lastName','password', 'username'];

export default DS.Model.extend({
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

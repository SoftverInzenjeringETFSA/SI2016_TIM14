import DS from 'ember-data';

export default DS.Model.extend({
     id: DS.attr(),
     firstName: DS.attr(),
     lastName: DS.attr(),
     username: DS.attr(),
     email: DS.attr(),
     gender: DS.attr(),
     dateOfBirth: DS.attr(),
     location: DS.attr(),
     about: DS.attr(),
     isAdmin: DS.attr()
});

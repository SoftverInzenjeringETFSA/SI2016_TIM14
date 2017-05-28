import Ember from 'ember';
import Group from '../models/group';

export default Ember.Controller.extend({
  groupService: Ember.inject.service('group-service'),
  session: Ember.inject.service(),
  name: null,
  description: null,
  actions: {
     kreirajGrupu() {
      let grupa = this.getProperties('name', 'description');
      grupa.name= this.get('name');
      grupa.description = this.get('description');
      this.get('groupService').createGroup(grupa);
      this.set('name', '');
      this.set('description', '');
    }
  }

});

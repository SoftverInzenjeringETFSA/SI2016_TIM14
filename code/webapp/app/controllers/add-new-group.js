import Ember from 'ember';
import Group from '../models/group';

export default Ember.Controller.extend({
  groupService: Ember.inject.service('group-service'),
  session: Ember.inject.service(),
  actions: {
		 kreirajGrupu() {
      let grupa = this.getProperties('name', 'description');
			grupa.name= this.get('name');
      grupa.description = this.get('description');
console.log(this.get('name'));
console.log('helooou');

      this.get('groupService').createGroup(grupa);
		}
	}

});

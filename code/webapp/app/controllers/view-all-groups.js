import Ember from 'ember';
import grupa from '../models/group';

export default Ember.Controller.extend({
	groupService: Ember.inject.service('group-service'),
	session: Ember.inject.service(),
	Message: '',

	actions: {
		 obrišiGrupu(idgrupa) {

           this.get('groupService').deleteGroup(idgrupa);
           Ember.set(this, 'Message', 'Uspješno obrisana grupa!');
           window.location.reload(true); 
	}

	}

});
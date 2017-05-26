import Ember from 'ember';


export default Ember.Controller.extend({
	inviteUserService: Ember.inject.service('inviteuser-service'),
	session:  Ember.inject.service(),
	actions: {
		/*inviteUser(params) {
			console.log('PROVJERA PROFIL');
			console.log(params);
			this.get('inviteUserService').inviteUser(params);
		}*/
	}
});
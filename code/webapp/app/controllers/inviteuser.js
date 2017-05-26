import Ember from 'ember';


export default Ember.Controller.extend({
	inviteUserService: Ember.inject.service('inviteuser-service'),
	    session: Ember.inject.service(),
	actions: {
		inviteUser(params) {
			var usernameOfInviter = this.get('session.data.authenticated.korisnik.username');
			var idOfInviter = this.get('session.data.authenticated.korisnik.id');
			this.get('inviteUserService').inviteUser(params, usernameOfInviter, idOfInviter);
		}
	}
});

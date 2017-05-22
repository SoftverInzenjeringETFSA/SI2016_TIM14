import Ember from 'ember';


export default Ember.Controller.extend({
	inviteUserService: Ember.inject.service('inviteuser-service'),
	actions: {
		inviteUser(params) {
			console.log('Fuck Yeah');
			console.log(params);
			this.get('inviteUserService').inviteUser(params);
		}
	}
});

import Ember from 'ember';

export default Ember.Route.extend({
	userService: Ember.inject.service(),
	model: function(params, transition) {
		let users = this.get('userService').all();
	    return Ember.RSVP.hash({
	        searchedUsers: users
	    });
	}
});
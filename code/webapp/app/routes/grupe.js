import Ember from 'ember';

export default Ember.Route.extend({
	groupService: Ember.inject.service(),
	session: Ember.inject.service(),
	model: function() {
		var idOfUser = this.get('session.data.authenticated.korisnik.id');
	    let groups = this.get('groupService').myGroups(idOfUser);
	    return Ember.RSVP.hash({
	        searchedGroups: groups
	    });
	}
});

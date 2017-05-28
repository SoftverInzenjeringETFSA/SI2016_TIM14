import Ember from 'ember';

export default Ember.Route.extend({
	groupService: Ember.inject.service(),
	model: function() {
	    let groups = this.get('groupService').all();
	    return Ember.RSVP.hash({
	        searchedGroups: groups
	    });
	}
});

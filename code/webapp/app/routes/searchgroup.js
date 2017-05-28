import Ember from 'ember';

export default Ember.Route.extend({

  groupService: Ember.inject.service(),
	model: function(params, transition) {

	    let groups = this.get('groupService').searchGroups(params.searchgroupTerm);
	    return Ember.RSVP.hash({
	        searchedGroups: groups
	    });
	}
});

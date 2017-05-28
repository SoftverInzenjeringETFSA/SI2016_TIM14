import Ember from 'ember';
import user from '../models/group';

export default Ember.Controller.extend({
        groupService: Ember.inject.service(),
        ajax: Ember.inject.service(),
        self : this,


    model: function() {
    },
    searchGroups: function(params){
        let groups = this.get('groupService').searchGroups(params);
        console.log(groups);
        this.set("model.searchedGroups", groups);
    },

    actions: {
        searchGroups() {
            var params = this.get('search');
            this.searchGroups(params);
        },
    }
});

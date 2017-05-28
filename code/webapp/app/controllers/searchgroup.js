import Ember from 'ember';
import user from '../models/group';

export default Ember.Controller.extend({
        groupService: Ember.inject.service(),
        ajax: Ember.inject.service(),
        self : this,
        session: Ember.inject.service(),


    model: function() {
    },
    searchGroups: function(params){
        let groups = this.get('groupService').searchGroups(params);
        this.set("model.searchedGroups", groups);
    },

    joinGroup: function(params) {
        var idOfGroup = params;
        var idOfUser = this.get('session.data.authenticated.korisnik.id');

        this.get('groupService').joinGroup(idOfGroup, idOfUser);
    },

    actions: {
        searchGroups() {
            var params = this.get('search');
            this.searchGroups(params);
        },
        joinGroup(params) {
            this.joinGroup(params);
            
        }
    }
});

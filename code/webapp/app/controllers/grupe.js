import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
    groupService: Ember.inject.service(),
        ajax: Ember.inject.service(),
        self : this,
        session: Ember.inject.service(),

    model: function() {
    },
    refreshGroup: function(params){
        var idOfUser = this.get('session.data.authenticated.korisnik.id');
        this.get('groupService').leaveGroup(params, idOfUser);
        let groups = this.get('groupService').myGroups(idOfUser);
        this.set("model.searchedGroups", groups);
    },
    actions: {
        leaveGroup(params) {          
            this.refreshGroup(params);
        }
         

      
        
    }
});

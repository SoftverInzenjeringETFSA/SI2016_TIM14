import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
        userService: Ember.inject.service(),
        ajax: Ember.inject.service(),
        self : this,


    model: function() {
    },
    searchUser: function(params){
        let users = this.get('userService').searchUsers(params);
        this.set("model.searchedUsers", users);
    },

    actions: {
        searchUser() {
            var params = this.get('search');
            this.searchUser(params);
        },
         
    }
});

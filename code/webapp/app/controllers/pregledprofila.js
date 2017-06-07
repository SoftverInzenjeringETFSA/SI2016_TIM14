import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
        userService: Ember.inject.service(),
        ajax: Ember.inject.service(),
        self : this,
    model: function() {
    }
});
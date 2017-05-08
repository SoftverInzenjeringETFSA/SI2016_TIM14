import Ember from 'ember';

export default Ember.Route.extend({
    beforeModel() {
        // redirect to login
        this.replaceWith('login');
    }
});

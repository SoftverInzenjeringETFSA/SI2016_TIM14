import Ember from 'ember';

export default Ember.Route.extend({
   beforeModel() {
    this.transitionTo('login'); // Implicitly aborts the on-going transition.
  }
});
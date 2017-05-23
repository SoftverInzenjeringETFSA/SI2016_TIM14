import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('login');
  this.route('home');
  this.route('profil');
  this.route('grupe');
  this.route('privatnichat');
  this.route('adminpanel');
  this.route('inviteuser');
  this.route('searchuser');
});

export default Router;

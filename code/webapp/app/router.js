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
  this.route('edit-profil');
  this.route('add-new-group');
  this.route('view-all-groups');
  this.route('view-all-users');
  this.route('view-ban-requests');
  this.route('inviteuser');
  this.route('edit-sifra');
  this.route('invites');
  this.route('notifications');
  this.route('searchuser', {
        path: "/searchuser/:searchuserTerm"});
  this.route('searchgroup', {
        path: "/searchgroup/:searchgroupTerm"});



  this.route('pregledprofila', {
         path: "/pregledprofila/:term"});
  this.route('faq');
});

export default Router;

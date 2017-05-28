import Ember from 'ember';
import BaseService from './base-service';
import Group from '../models/group';

export default BaseService.extend({
  session: Ember.inject.service(),
  all: function() {
      var grupe = [];
      this.ajax({ url: `grupe/all`, type: "GET"}).then(function(data) {
          data.forEach(function(group) {
              grupe.addObject(Group.create(group));
          });

      });
      return grupe;

  },

  searchGroups: function(searchTerm){
      var groups = [];
      this.ajax({ url: `grupe/searchGroups?searchTerm=${searchTerm}`, type: "GET"}).then(function(data) {
          data.forEach(function(group) {
              groups.addObject(Group.create(group));
          });
      });
      return groups;
  }
});

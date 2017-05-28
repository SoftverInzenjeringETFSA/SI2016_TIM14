import Ember from 'ember';
import BaseService from './base-service';
import Group from '../models/group';

export default BaseService.extend({
  session: Ember.inject.service(),
  all: function() {
      var grupe = [];
      this.ajax({ url: `grupe/all`, type: "GET"}).then(function(data) {
        //console.log(data);
          data.forEach(function(group) {
              grupe.addObject(Group.create(group));
              //console.log(group);
              console.log('jebeeeeeeem ti sve')
          });

      });
      return grupe;

  },

  searchGroups: function(searchTerm){
      var groups = [];
      this.ajax({ url: `grupe/searchGroups?searchTerm=${searchTerm}`, type: "GET"}).then(function(data) {
        //console.log(data);
          data.forEach(function(group) {
              groups.addObject(Group.create(group));
              console.log('fuuuck');
          });
      });
      //console.log(groups);
      return groups;
  }
});

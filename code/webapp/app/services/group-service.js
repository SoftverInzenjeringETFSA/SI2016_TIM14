import Ember from 'ember';
import BaseService from './base-service';
import Group from '../models/group';

export default BaseService.extend({
  createGroup: function(grupa) {
      var grupe = [];
      this.ajax({ url: `grupe/kreirajgrupu`, type: "POST", data: JSON.stringify(grupa)}).then(function(data) {
      });

      return true;
  }
});

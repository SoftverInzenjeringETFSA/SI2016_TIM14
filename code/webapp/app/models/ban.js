import DS from 'ember-data';

var _modelProperties = ['id','reason','requestedId', 'targetId','chatGroupId', 'sourceusername', 'targetusername', 'groupname'];

export default DS.Model.extend({
     modelProperties: _modelProperties,
});

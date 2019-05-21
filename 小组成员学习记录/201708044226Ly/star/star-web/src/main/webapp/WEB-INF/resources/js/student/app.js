Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'student',
	appFolder : server_context + '/resources/js/student/app',
	controllers : [ 'StudentController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'studentGrid'
			} ]
		});
	}
});

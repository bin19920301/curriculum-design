webpackJsonp([9],{"5mjB":function(e,t){},OopA:function(e,t){},"PQ+j":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={name:"course",data:function(){return{editVisible:!1,checked:!1,tableData:[{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"王小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"王小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"王小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-03",name:"王小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-03",name:"王小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-03",name:"王小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-03",name:"王小虎",address:"上海市普陀区金沙江路 1516 弄"}],options:[{value:"选项1",label:"黄金糕"},{value:"选项2",label:"双皮奶"},{value:"选项3",label:"蚵仔煎"},{value:"选项4",label:"龙须面"},{value:"选项5",label:"北京烤鸭"}],value:"",form:{name:"",region:"",date1:"",date2:"",delivery:!0,type:["步步高"],resource:"小天才",desc:"",options:[]}}},methods:{handleEdit:function(e,t){console.log(e,t)},deldataone:function(e,t){var a=this;this.$confirm("确定要删除吗？","提示",{type:"warning"}).then(function(){a.$message.success("删除成功"),a.tableData.splice(e,1)}).catch(function(){})},modifyStuList:function(){this.editVisible=!0}}},s={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"newworks"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 作业项目\n            ")]),e._v(" "),a("el-breadcrumb-item",[e._v("新建作业项目")])],1)],1),e._v(" "),a("div",{staticClass:"container"},[a("div",{staticClass:"form"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"110px"}},[a("el-form-item",{attrs:{label:"作业名称："}},[a("el-input",{attrs:{size:"small"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"简介："}},[a("el-input",{attrs:{size:"small",type:"textarea",rows:"5"},model:{value:e.form.desc,callback:function(t){e.$set(e.form,"desc",t)},expression:"form.desc"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"资料："}},[a("div",{staticClass:"data-out"},[a("p",{staticClass:"data-bg"},[a("span",[e._v("车床吉林省管.png")]),e._v(" "),a("i",{staticClass:"deldata el-icon-delete",on:{click:e.deldataone}})]),e._v(" "),a("p",{staticClass:"data-bg"},[a("span",[e._v("车床吉林省管.png")]),e._v(" "),a("i",{staticClass:"deldata el-icon-delete",on:{click:e.deldataone}})]),e._v(" "),a("el-button",{attrs:{size:"mini"},on:{click:e.modifyStuList}},[e._v("添加资料")])],1)]),e._v(" "),a("el-form-item",[a("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.saveEdit}},[e._v("保 存")]),e._v(" "),a("el-button",{attrs:{size:"small"},on:{click:function(t){e.editVisible=!1}}},[e._v("取 消")])],1)],1)],1)]),e._v(" "),a("el-dialog",{attrs:{title:"添加资料",visible:e.editVisible,width:"500px"},on:{"update:visible":function(t){e.editVisible=t}}},[a("div",{staticClass:"select-bg"},[a("span",[e._v("筛选文件夹：")]),e._v(" "),a("el-select",{attrs:{size:"small",placeholder:"请选择"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-table",{ref:"multipleTable",staticClass:"editlist",staticStyle:{width:"100%"},attrs:{size:"mini",data:e.tableData,"tooltip-effect":"dark",height:"300px"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"全选"}})],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.editVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.saveEdit}},[e._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var i=a("VU/8")(l,s,!1,function(e){a("OopA"),a("5mjB")},"data-v-23ac2e5c",null);t.default=i.exports}});
//# sourceMappingURL=9.655fcff27f4a74b412fc.js.map
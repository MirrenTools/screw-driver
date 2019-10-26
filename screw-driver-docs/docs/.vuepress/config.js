module.exports = {
  title: 'ScrewDriver V1.1.0',
	description: '用于生成代码、创建或读取数据库表的工具包',
	dest:'dist',
	themeConfig: {
	displayAllHeaders: true,
	activeHeaderLinks: false,
  	nav:[
			{ text: 'MirrenTools', link: 'https://mirrentools.org'},
			{ text: 'github', link: 'https://github.com/MirrenTools/screw-driver'},
			{ text: 'gitee', link: 'https://gitee.com/duhua/screw-driver'}
		],
  	sidebar:{
  		'/':[{title:'使用说明', collapsable: false,children:['/start/introduction','/start/core-class-intro']}]
  		}
    }
}
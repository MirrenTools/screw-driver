module.exports = {
	base: '/screw-driver-docs/',
	title: 'ScrewDriver V1.1.0',
	description: '用于生成代码、创建或读取数据库表的工具包',
	dest: 'dist',
	themeConfig: {
		nav: [{
				text: 'MirrenTools',
				link: 'https://mirrentools.org'
			},
			{
				text: 'github',
				link: 'https://github.com/MirrenTools/screw-driver'
			},
			{
				text: 'gitee',
				link: 'https://gitee.com/mirren/screw-driver'
			}
		],
		sidebar: {
			'/': [{
				title: '使用说明',
				collapsable: false,
				children: ['/start/introduction', '/start/core-class-intro','/start/sd-type','/start/ide-code-block','/start/template-rule','/start/template-attr','/start/sql-assist','/start/expand','/start/license']
			}]
		}
	}
}

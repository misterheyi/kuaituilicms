	 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"内容管理",
							"menus":[
									{"menuid":"12","menuname":"短文管理","icon":"icon-add","url":basePath+"essay/toListEssay"},
									{"menuid":"13","menuname":"谜语管理","icon":"icon-users","url":basePath+"riddle/toListRiddle"},
									{"menuid":"14","menuname":"名家管理","icon":"icon-role","url":basePath+"famous/toListFamous"},
									{"menuid":"15","menuname":"未解之谜","icon":"icon-set","url":basePath+"mystery/toListMystery"},
									{"menuid":"16","menuname":"咨询中心","icon":"icon-log","url":basePath+"info/toListInfo"},
									{"menuid":"17","menuname":"百科中心","icon":"icon-log","url":basePath+"baike/toListBaike"}
								]
						}
				]};
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '/ajax/loginout.ashx';
                    }
                });
            })
        });
		
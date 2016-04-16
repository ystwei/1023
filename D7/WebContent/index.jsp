<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<HTML>
	<HEAD>
		<TITLE>留言板</TITLE>
	</HEAD>
	<LINK href="css/MessageCss.css" type=text/css
		rel=stylesheet>
	<BODY>

		<TABLE width="90%" align="center" border=1 cellspacing="0"
			cellpadding="0" bordercolordark="#CCCC99" bordercolorlight="#CCCC99">
			<TR>
				<TD align="center" bgcolor="#CCCC99">
					访客留言板
				</TD>
			</TR>
			<TR>
				<TD>
					<FORM ACTION="message?action=add" method="post">
						<TABLE align="center" border=1 cellspacing="0" cellpadding="0"
							bordercolordark="#CCCC99" bordercolorlight="#CCCC99">
							<TR>
								<TD>
									姓名：
								</TD>
								<TD bgcolor="#CCCC99">
									<input type="text" name="name" size=25>
								</TD>
							</TR>
							<TR>
								<TD bgcolor="#CCCC99">
									E-mail：
								</TD>
								<TD bgcolor="#CCCC99">
									<input type="text" name="email" size=25>
								</TD>
							</TR>
							<TR>
								<TD>
									主题：
								</TD>
								<TD bgcolor="#CCCC99">
									<input type="text" name="title" size=25>
								</TD>
							</TR>
							<TR>
								<TD valign="top" bgcolor="#CCCC99">
									留言：
								</TD>
								<TD>
									<textarea name="content" rows=7 cols=25>
										
									</textarea>
								</TD>
							</TR>
							<TR>
								<TD colspan=3>
									<TABLE align="center" width="100%" cellspacing="0"
										cellpadding="0" bordercolordark="#CCCC99"
										bordercolorlight="#CCCC99">
										<TR>
											<TD align="center" bgcolor="#CCCC99">
												<input type="submit" value="提交留言">
											</TD>
											<TD align="center">
												<!-- href的地址要和web.xml中的 url-pattern 一致 -->
												<a href="message?action=view"><font size=2>查看留言</font>
												</a>
											</TD>
											<TD align="center" bgcolor="#CCCC99">
												<input type="reset" value="重新填写">
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>

						</TABLE>
					</FORM>
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/exc3.css" type="text/css"/>
</head>
<body>

<h1>Downloads</h1>

<h2>Joe Rut - Genuine Wood Grained Finish</h2>
    
<table>
<tr>
    <th>Song title</th>
    <th>Audio Format</th>
</tr>
<tr>
    <td width="200"><b>Song title</b></td>
    <td width="150"><b>Audio Format</b></td>
</tr>
<tr>
    <td>Filter</td>
    <td><a href="download/musicStore/sound/${productCode}/filter.mp3">MP3</a></td>
</tr>
<tr>
    <td>So Long Lazy Ray</td>
    <td><a href="download/musicStore/sound/${productCode}/so_long.mp3">MP3</a></td>
</tr>
</table>

<p><a href="?action=viewAlbums">View list of albums</a></p>

<p><a href="?action=viewCookies">View all cookies</a></p>

</body>
</html>
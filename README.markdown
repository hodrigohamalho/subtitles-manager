Subtitles Manager
=================

Objective
---------

This project aims to manage the timing of the subtitles of a movie.

How it works?
-------------

1. The user uploads the legenda.srt and indicates how long the caption is
delayed or advanced.
2. The system processes the file and adjust the subtitle timing.
3. The system provides this new file to download.


Setup project:
--------------

This project use maven framework, so few steps is necessary to import in Eclipse IDE.

1. Get the project 
	#``` git clone git@github.com:hodrigohamalho/subtitles-manager.git ```#
2. Execute maven tasks
	mvn clean eclipse:clean eclipse:eclipse
3. Now you can import to eclipse

Note: This Application use Servlet 3.0 API, so you need a container web that support it, like apache tomcat 7.0
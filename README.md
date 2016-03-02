# Ochestrating Microservices using Twitter

Two different projects which show how Twitter can be used to ochestrate microservices.

#Weather Poller

The Weather poller at the moment hooks update a Mongo db and updates every 2 minutes with the latest weather. Currently however, the weather polling is stubbed out. The only thing to really change is the date.

#Frontend
This app represents the front end. When it seens a request with the #hastag of "#wp_u" (which stands for weatherpoller with the action updated) it will send a request to the poller. It will then send a direct message to my twitter handle. 

#More info
I wrote a blog about this a while ago. You can view it here: http://harrywinser.com/posts/twitter_as_microservice_orchestrator



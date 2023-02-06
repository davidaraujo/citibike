export region=nyc

ps -ef | grep bicyclesharing.$region.properties | grep -v grep | awk '{print $2}' | xargs kill -9




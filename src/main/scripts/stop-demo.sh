ps -ef | grep bicyclesharing.nyc.properties | grep -v grep | awk '{print $2}' | xargs kill -9

java -jar -server -d64 \
	-Derrorcode.properties=/home/admin/RestService/config/ErrorCode.properties \
    -Xms200m -Xmx200m \
    -XX:+UseParallelOldGC -XX:ParallelGCThreads=3 -XX:-UseConcMarkSweepGC -XX:+UseAdaptiveSizePolicy \
    -XX:+DisableExplicitGC -XX:SurvivorRatio=5 -XX:GCTimeLimit=90 \
    -XX:+UseParallelGC -XX:MaxNewSize=50m -XX:NewSize=50m \
    -XX:MaxTenuringThreshold=0 -XX:CMSInitiatingOccupancyFraction=60 \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:HeapDumpPath=/home/admin/RestService/logs \
    -Dfile.encoding=utf-8 \
    /home/admin/RestService/RestTemplateService.jar \
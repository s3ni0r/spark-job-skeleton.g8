  #!/bin/bash
# debug
set -x
# abort if any error occured
set -e
# disable globbing
#set -f
# disable splitting
#IFS=''
# raise an error when an undefined variable has been used
set -u
# abort when a pipe failed = bash only: doesn't work in POSIX sh
if [ "\${BASH:-}" = '/bin/bash' ]; then set -o pipefail; fi

hadoop fs -copyFromLocal /data /
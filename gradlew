#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}
    [ -L "$app_path" ]
do
    app_path=$(ls -ld -- "$app_path") ||
    exit 1
    app_path=$([[ $app_path =~ ^(.*)-\>  (.*)$ ]] && echo "${BASH_REMATCH[2]}" || echo "$app_path")
done

APP_HOME=$(cd "${APP_HOME}" && pwd -P) || exit

APP_NAME="Gradle"
APP_BASE_NAME=${0##*/}
export APP_HOME
export APP_BASE_NAME

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='" -Xmx64m" "-Xms64m"'

# Use the maximum available, or set MAX_FD != maximum.
MAX_FD=maximum

warn()
{
    echo "$*" >&2
}

die()
{
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
darwin=false
msys=false
cygwin=false
nativewin=false
case "$(uname)" in
  Darwin* )
        darwin=true
        ;;
  MINGW* )
        msys=true
        ;;
  CYGWIN* )
        cygwin=true
        ;;
  MSYS* )
        nativewin=true
        ;;
esac

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$darwin" && ! "$msys" && ! "$nativewin" ; then
    case $( ulimit -S -n ) in
      'unlimited'|*'65536'*)
        ulimit -n 1048576
        ;;
      *)
        warn "Could not query maximum file descriptor limit"
        ;;
    esac
fi

# For Darwin, add options to specify how the application appears in the dock
if $darwin; then
    DEFAULT_JVM_OPTS="$DEFAULT_JVM_OPTS '-Xdock:name=Gradle' '-Xdock:icon=$APP_HOME/media/gradle.icns'"
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=$( cygpath --path --mixed "$APP_HOME" )
    APP_BASE_NAME=$( cygpath --file-name-only "$0" )
    CLASSPATH=$( cygpath --path --mixed "$CLASSPATH" )
    JAVACMD=$( cygpath --unix "$JAVACMD" )
    for arg in "$@" ; do
        if [[ "$arg" =~ ^-.*\\.jar$ ]] ; then
            arg=$( cygpath --path --windows "$arg" )
        fi
        APP_ARGS+=( "$arg" )
    done
fi

# This is normally unused
app_base_name=$APP_BASE_NAME
exec "$JAVACMD" "${DEFAULT_JVM_OPTS[@]}" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"

#!/usr/bin/env bash

function echoUsage() {
    echo "usage: $(basename $0) [-h]" >&2
    echo "This script updates 'nextprot-user-queries' on your machine."
    echo "Params:"
    echo "Options:"
    echo " -h print usage"
}

while getopts 'h' OPTION
do
    case ${OPTION} in
    h) echoUsage
        exit 0
        ;;
    ?) echoUsage
        exit 1
        ;;
    esac
done

git checkout develop
git pull

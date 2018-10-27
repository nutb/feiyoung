package com.admxj.kd.admxjkd.utils;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admxj on 2018/10/27.
 */

public class SSHUtils {

    private static final String ENCODING = "UTF-8";

    private DestHost destHost = null;

    public SSHUtils(DestHost destHost){
        this.destHost = destHost;
    }

    public Session getJSchSession() throws JSchException {
        JSch jsch = new JSch();

        Session session = jsch.getSession(destHost.getUsername(), destHost.getHost(), destHost.getPort());
        session.setPassword(destHost.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");  // 第一次访问服务器时不用输入yes
        session.setTimeout(destHost.getTimeout());
        session.connect();

        return session;
    }

    public String execCommandByJSch(String command) throws IOException, JSchException {
        return execCommandByJSch(command, ENCODING);
    }

    public String execCommandByJSch(String command, String resultEncoding) throws IOException, JSchException {
        Session session = getJSchSession();
        String result = execCommandByJSch(session, command, resultEncoding);
        session.disconnect();

        return result;
    }

    public String execCommandByJSch(Session session, String command) throws IOException, JSchException {
        return execCommandByJSch(session, command, ENCODING);
    }

    public String execCommandByJSch(Session session, String command, String resultEncoding) throws IOException, JSchException {
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand(command);
        channelExec.setErrStream(System.err);
        channelExec.connect();

        String result = IOUtils.toString(in, resultEncoding);

        channelExec.disconnect();

        return result;
    }

}

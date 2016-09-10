package com.group.internet;

import java.io.OutputStream;

import com.group.utils.PersonInfo;

/**
 * ����˵�һЩ�ӿ�
 * @author Administrator
 *
 */
public interface InternetFace {
	
	/**
	 * ��½
	 * @param username
	 * @param passward
	 * @return 1 Ϊ�ɹ���0Ϊʧ��
	 */
	public int Login(String username,String passward);
	
	/**
	 * ע��
	 * @param info
	 * @return
	 */
	public String Register(PersonInfo info);
	
	
	/**
	 *�����ı���Ϣ
	 * @param from ���ͷ�
	 * @param to	���շ�
	 * @param text	�ı�
	 * @return 1 Ϊ�ɹ���0Ϊʧ��
	 */
	public int sendText(String from,String to,String text);
	
	public int sendText(String from,String to,OutputStream out);
	
	/**
	 *�����ı���Ϣ
	 * @param to	���շ�
	 * @param text	�ı�
	 * @return  1 Ϊ�ɹ���0Ϊʧ��
	 */
	public int sendText(String to,String text);
	
	/**
	 * �����ļ�
	 * @param to
	 * @param path
	 * @return
	 */
	public int sendFile(String to,String path);
	
	public int sendFile(String from ,String to,String path);
	
	public int sendFile(String to,OutputStream out);
	
	/**
	 * 
	 * @param who 
	 * @return ���ظ�����Ϣ
	 */
	public PersonInfo getPersonInfo(String who);
	
	
	
}

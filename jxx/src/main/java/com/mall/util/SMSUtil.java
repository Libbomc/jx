package com.mall.util;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SMSUtil {

    /**
     * //产品名称：云通信API产品
     * static final String product="Dysmsapi";
     * //产品域名，开发者无须替换
     * static final String domain="dysmsapi.aliyuncs.com";
     * //todo
     * static final String accessKeyId="LTAIZLwMV7keeUxt";
     * static final String accessKeySecret="kUl8nNW6xEoyRWcaVnJR7xHvVqd5RQ";
     * <p>
     * public static String phone;
     * <p>
     * public static String getPhone() {
     * return phone;
     * }
     * <p>
     * public static void setPhone(String phone) {
     * SMSUtil.phone = phone;
     * }
     * <p>
     * public static SendSmsResponse sendSms() throws ClientException{
     * <p>
     * //可自助调整超时时间
     * System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
     * System.setProperty("sun.net.client.defaultReadTimeout", "10000");
     * //初始化acsClient,暂不支持region化
     * IClientProfile profile=DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
     * DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
     * IAcsClient acsClient=new DefaultAcsClient(profile);
     * //组装请求对象-具体描述见控制台-文档部分内容
     * SendSmsRequest request=new SendSmsRequest();
     * //必填:待发送手机号
     * request.setPhoneNumbers(phone);
     * //必填:短信签名-可在短信控制台中找到举个例子
     * request.setSignName("yslawk");
     * //必填:短信模板id-可在短信控制台中找到，是id不是名字，举个例子
     * request.setTemplateCode("SMS_135033239");
     * //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为--必填，与模板相对应
     * //request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
     * request.setTemplateParam("{\"code\":\"666666\"}");
     * //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
     * //request.setSmsUpExtendCode("90997");
     * //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
     * //request.setOutId("yourOutId");
     * //hint 此处可能会抛出异常，注意catch
     * SendSmsResponse sendSmsResponse=acsClient.getAcsResponse(request);
     * return sendSmsResponse;
     * }
     * <p>
     * <p>
     * public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {
     * <p>
     * //可自助调整超时时间
     * System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
     * System.setProperty("sun.net.client.defaultReadTimeout", "10000");
     * <p>
     * //初始化acsClient,暂不支持region化
     * IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
     * DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
     * IAcsClient acsClient = new DefaultAcsClient(profile);
     * //组装请求对象
     * QuerySendDetailsRequest request = new QuerySendDetailsRequest();
     * //必填-号码
     * request.setPhoneNumber(phone);
     * //可选-流水号
     * request.setBizId(bizId);
     * //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
     * SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
     * request.setSendDate(ft.format(new Date()));
     * //必填-页大小
     * request.setPageSize(10L);
     * //必填-当前页码从1开始计数
     * request.setCurrentPage(1L);
     * <p>
     * //hint 此处可能会抛出异常，注意catch
     * QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
     * <p>
     * return querySendDetailsResponse;
     * }
     * <p>
     * <p>
     * <p>
     * <p>
     * public static void main(String[] args) throws ClientException, InterruptedException {
     * <p>
     * //发短信
     * SendSmsResponse response = sendSms();
     * System.out.println("短信接口返回的数据----------------");
     * System.out.println("Code=" + response.getCode());
     * System.out.println("Message=" + response.getMessage());
     * System.out.println("RequestId=" + response.getRequestId());
     * System.out.println("BizId=" + response.getBizId());
     * <p>
     * Thread.sleep(3000L);
     * <p>
     * //查明细
     * if(response.getCode() != null && response.getCode().equals("OK")) {
     * QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
     * System.out.println("短信明细查询接口返回数据----------------");
     * System.out.println("Code=" + querySendDetailsResponse.getCode());
     * System.out.println("Message=" + querySendDetailsResponse.getMessage());
     * int i = 0;
     * for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
     * {
     * System.out.println("SmsSendDetailDTO["+i+"]:");
     * System.out.println("Content=" + smsSendDetailDTO.getContent());
     * System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
     * System.out.println("OutId=" + smsSendDetailDTO.getOutId());
     * System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
     * System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
     * System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
     * System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
     * System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
     * }
     * System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
     * System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
     * }
     * <p>
     * }
     */

//产品名称：云通信API产品
    static final String product = "Dysmsapi";
    //产品域名，开发者无须替换
    static final String domain = "dysmsapi.aliyuncs.com";
    //todo
    static final String accessKeyId = "LTAIZLwMV7keeUxt";
    static final String accessKeySecret = "kUl8nNW6xEoyRWcaVnJR7xHvVqd5RQ";

    public static int code;

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        SMSUtil.code = code;
    }

    public static String getsms(String number) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //随机生成六位验证码
         code= (int) ((Math.random() * 9 + 1) * 100000);
         System.out.println("验证码："+code);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(number);
        //必填:短信签名-可在短信控制台中找到，你在签名管理里的内容
        //必填:短信签名-可在短信控制台中找到举个例子
        request.setSignName("yslawk");
        //必填:短信模板id-可在短信控制台中找到，是id不是名字，举个例子
        request.setTemplateCode("SMS_135033239");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + code + "\"}");


        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //获取发送状态
        String cod = sendSmsResponse.getCode();
        System.out.println("短信接口返回的数据：");
        System.out.println("Code=" + sendSmsResponse.getCode());
        System.out.println("Message=" + sendSmsResponse.getMessage());
        System.out.println("RequestId=" + sendSmsResponse.getRequestId());
        System.out.println("BizId=" + sendSmsResponse.getBizId());
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(sendSmsResponse.getBizId());
            System.out.println("短信明细查询接口返回数据----------------");
            System.out.println("Code=" + querySendDetailsResponse.getCode());
            System.out.println("Message=" + querySendDetailsResponse.getMessage());
            int i = 0;
            for (QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs()) {
                System.out.println("SmsSendDetailDTO[" + i + "]:");
                System.out.println("Content=" + smsSendDetailDTO.getContent());
                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
            }
            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
        }
        System.out.println("111111111111111");
        System.out.println(cod);
        return cod;
    }


    public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber("15000000000");
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }


}

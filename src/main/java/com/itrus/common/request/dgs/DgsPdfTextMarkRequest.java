package com.itrus.common.request.dgs;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itrus.common.request.dgs.entity.PositionArray;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName PdfTextMarkParams
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 14:59 2020/4/1
 * @Modified By:
 * @Version 1.0
 * 添加文本水印请求参数实体
 **/

@ToString
@Component
@Data
public class DgsPdfTextMarkRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * pdf文件的base64编码
     */
    private String pdfData;

    /**
     * 水印文字；
     */
    private String text;
    /**
     * 开始页码；范围：1至total；如果等于null或者小于1或者大于total或者大于endPage，默认为1；（total：总页数
     */
    private Integer beginPage;
    /**
     * 结束页码；范围：1至total；如果等于null或者小于1或者大于total或者小于beginPage，默认为total；（total：总页数）
     */
    private Integer endPage;
    /**
     * 透明度；范围：0至1；0：透明，1：不透明；如果等于null，默认为1；如果小于0，默认为0；如果大于1，默认为1；
     */
    private Float opacity;
    /**
     * 旋转角度；正数：逆时针旋转，负数：顺时针旋转；如果等于null，默认为0；
     */
    private Float rotation;
    /**
     * 文字大小；如果等于null，默认为12；如果为负数，则指定大小同时逆时针旋转180度；
     */
    private Float fontSize;
    /**
     * RGB颜色的R值；范围：0至255；如果等于null或者小于0或者大于255，默认为0；
     */
    private Integer colorR;
    /**
     * RGB颜色的G值；范围：0至255；如果等于null或者小于0或者大于255，默认为0；
     */
    private Integer colorG;
    /**
     * RGB颜色的B值；范围：0至255；如果等于null或者小于0或者大于255，默认为0；
     */
    private Integer colorB;
    /**
     * 对齐方式的枚举的字符串参数；范围：LEFT_BOTTOM，LEFT_TOP，RIGHT_BOTTOM，RIGHT_TOP，CENTER，TILED，STRET；接口会根据参数生成对应的坐标；（如果align和positionArray同时为空，则默认一个x=0且y=0的坐标）
     */
    private String align;
    /**
     * 边距；如果等于null或者小于0，默认为30；
     */
    private Float margin;
    /**
     * 坐标数组；如果等于null，则指定一个x=0且y=0的坐标为默认坐标；
     */
    private List<PositionArray> positionArray;

}

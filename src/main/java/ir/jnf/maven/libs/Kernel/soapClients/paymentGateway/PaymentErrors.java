/**
 *
 */
package ir.jnf.maven.libs.Kernel.soapClients.paymentGateway;

import java.io.Serializable;

/**
 * @author eae966
 *
 */
public class PaymentErrors implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4354463540880947054L;

	/**
	 *
	 */
	public PaymentErrors() {
		// TODO Auto-generated constructor stub
	}

	public static final String Invalid_inputs = "InvalidInputs";
	public static final String Input_Has_Invalid_Characters = "InputHasInvalidCharacters";
	public static final String Invalid_Merchant_Code = "InvalidMerchantCode";
	public static final String Document_Completed_Before = "DocumentCompletedBefore";
	public static final String Receipt_is_empty = "ReceiptIsEmpty";
	public static final String Input_Is_Too_Long = "InputIsTooLong";
	public static final String Receipt_is_Not_Base64 = "ReceiptisNotBase64";
	public static final String Input_Is_Too_Short= "InputIsTooShort";
	public static final String Invalid_Ip_Address = "InvalidIpAddress";
	public static final String Part_Reverse_Is_Forbidden = "PartReverseIsForbidden";
	public static final String Internal_System_Error = "InternalSystemError";
	public static final String Amount_Is_Negative = "AmountIsNegative";
	public static final String Invalid_Part_Return = "InvalidPartReturn";
	public static final String Invalid_Transaction = "InvalidTransaction";
	public static final String Invalid_Amount = "InvalidAmount";
	public static final String Amount_Is_Not_Decimal = "AmountIsNotDecimal";
}

<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="simplify_if_kindof"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchremoveIf():V"/>
		<constant value="__exec__"/>
		<constant value="removeIf"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyremoveIf(NTransientLink;):V"/>
		<constant value="isKindOf"/>
		<constant value="MOCL!OclExpression;"/>
		<constant value="9:62-9:67"/>
		<constant value="MOCL!OperationCallExp;"/>
		<constant value="0"/>
		<constant value="oclIsKindOf"/>
		<constant value="J.=(J):J"/>
		<constant value="7"/>
		<constant value="source"/>
		<constant value="type_"/>
		<constant value="arguments"/>
		<constant value="J.first():J"/>
		<constant value="J.isSameType(J):J"/>
		<constant value="12:5-12:9"/>
		<constant value="12:5-12:14"/>
		<constant value="12:17-12:30"/>
		<constant value="12:5-12:30"/>
		<constant value="15:3-15:8"/>
		<constant value="13:3-13:7"/>
		<constant value="13:3-13:14"/>
		<constant value="13:3-13:20"/>
		<constant value="13:33-13:37"/>
		<constant value="13:33-13:47"/>
		<constant value="13:33-13:56"/>
		<constant value="13:33-13:62"/>
		<constant value="13:3-13:64"/>
		<constant value="12:2-16:7"/>
		<constant value="__matchremoveIf"/>
		<constant value="IfExp"/>
		<constant value="OCL"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="condition"/>
		<constant value="J.isKindOf():J"/>
		<constant value="B.not():B"/>
		<constant value="32"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="o"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="a"/>
		<constant value="Replace"/>
		<constant value="ACT"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="20:3-20:4"/>
		<constant value="20:3-20:14"/>
		<constant value="20:3-20:25"/>
		<constant value="22:5-25:3"/>
		<constant value="__applyremoveIf"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.refUnsetValue(S):J"/>
		<constant value="target"/>
		<constant value="23:14-23:15"/>
		<constant value="23:3-23:15"/>
		<constant value="24:14-24:15"/>
		<constant value="24:14-24:25"/>
		<constant value="24:3-24:25"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<pushf/>
		</code>
		<linenumbertable>
			<lne id="47" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="48"/>
		<parameters>
		</parameters>
		<code>
			<load arg="49"/>
			<get arg="38"/>
			<push arg="50"/>
			<call arg="51"/>
			<if arg="52"/>
			<pushf/>
			<goto arg="24"/>
			<load arg="49"/>
			<get arg="53"/>
			<get arg="54"/>
			<load arg="49"/>
			<get arg="55"/>
			<call arg="56"/>
			<get arg="54"/>
			<call arg="57"/>
		</code>
		<linenumbertable>
			<lne id="58" begin="0" end="0"/>
			<lne id="59" begin="0" end="1"/>
			<lne id="60" begin="2" end="2"/>
			<lne id="61" begin="0" end="3"/>
			<lne id="62" begin="5" end="5"/>
			<lne id="63" begin="7" end="7"/>
			<lne id="64" begin="7" end="8"/>
			<lne id="65" begin="7" end="9"/>
			<lne id="66" begin="10" end="10"/>
			<lne id="67" begin="10" end="11"/>
			<lne id="68" begin="10" end="12"/>
			<lne id="69" begin="10" end="13"/>
			<lne id="70" begin="7" end="14"/>
			<lne id="71" begin="0" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="14"/>
		</localvariabletable>
	</operation>
	<operation name="72">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="73"/>
			<push arg="74"/>
			<findme/>
			<push arg="75"/>
			<call arg="76"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="77"/>
			<call arg="78"/>
			<call arg="79"/>
			<if arg="80"/>
			<getasm/>
			<get arg="1"/>
			<push arg="81"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="82"/>
			<dup/>
			<push arg="83"/>
			<load arg="19"/>
			<pcall arg="84"/>
			<dup/>
			<push arg="85"/>
			<push arg="86"/>
			<push arg="87"/>
			<new/>
			<pcall arg="88"/>
			<pusht/>
			<pcall arg="89"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="90" begin="7" end="7"/>
			<lne id="91" begin="7" end="8"/>
			<lne id="92" begin="7" end="9"/>
			<lne id="93" begin="24" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="83" begin="6" end="31"/>
			<lve slot="0" name="17" begin="0" end="32"/>
		</localvariabletable>
	</operation>
	<operation name="94">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="95"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="83"/>
			<call arg="96"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="85"/>
			<call arg="97"/>
			<store arg="98"/>
			<load arg="98"/>
			<dup/>
			<push arg="53"/>
			<call arg="99"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<set arg="53"/>
			<dup/>
			<push arg="100"/>
			<call arg="99"/>
			<getasm/>
			<load arg="29"/>
			<get arg="77"/>
			<call arg="30"/>
			<set arg="100"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="101" begin="13" end="13"/>
			<lne id="102" begin="9" end="15"/>
			<lne id="103" begin="20" end="20"/>
			<lne id="104" begin="20" end="21"/>
			<lne id="105" begin="16" end="23"/>
			<lne id="93" begin="8" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="85" begin="7" end="24"/>
			<lve slot="2" name="83" begin="3" end="24"/>
			<lve slot="0" name="17" begin="0" end="24"/>
			<lve slot="1" name="106" begin="0" end="24"/>
		</localvariabletable>
	</operation>
</asm>
